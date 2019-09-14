

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './GoodsShelf.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (goodsShelf,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{goodsShelf.id}</Description> 
<Description term="位置">{goodsShelf.location}</Description> 
<Description term="最后更新时间">{ moment(goodsShelf.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = goodsShelf => {
  const {GoodsShelfBase} = GlobalComponents
  return <PermissionSetting targetObject={goodsShelf}  targetObjectMeta={GoodsShelfBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class GoodsShelfPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  goodsShelf = this.props.goodsShelf
    const { id,displayName, goodsShelfStockCountCount, goodsAllocationCount } = goodsShelf
    const  returnURL = `/goodsShelf/${id}/dashboard`
    const cardsData = {cardsName:"货架",cardsFor: "goodsShelf",cardsSource: goodsShelf,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  goodsShelf: state._goodsShelf,
}))(Form.create()(GoodsShelfPermission))


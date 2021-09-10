

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './GoodsShelfStockCount.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (goodsShelfStockCount,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{goodsShelfStockCount.id}</Description> 
<Description term="头衔">{goodsShelfStockCount.title}</Description> 
<Description term="计数时间">{ moment(goodsShelfStockCount.countTime).format('YYYY-MM-DD')}</Description> 
<Description term="概览">{goodsShelfStockCount.summary}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = goodsShelfStockCount => {
  const {GoodsShelfStockCountBase} = GlobalComponents
  return <PermissionSetting targetObject={goodsShelfStockCount}  targetObjectMeta={GoodsShelfStockCountBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class GoodsShelfStockCountPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  goodsShelfStockCount = this.props.goodsShelfStockCount
    const { id,displayName, stockCountIssueTrackCount } = goodsShelfStockCount
    const  returnURL = `/goodsShelfStockCount/${id}/workbench`
    const cardsData = {cardsName:"货架库存盘点",cardsFor: "goodsShelfStockCount",cardsSource: goodsShelfStockCount,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
       
        wrapperClassName={styles.advancedForm}
      >
      
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  goodsShelfStockCount: state._goodsShelfStockCount,
}))(Form.create()(GoodsShelfStockCountPermission))


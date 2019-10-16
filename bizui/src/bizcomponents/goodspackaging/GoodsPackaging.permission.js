

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './GoodsPackaging.profile.less'
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
const internalSummaryOf = (goodsPackaging,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{goodsPackaging.id}</Description> 
<Description term="包的名字">{goodsPackaging.packageName}</Description> 
<Description term="RFID">{goodsPackaging.rfid}</Description> 
<Description term="包的时间">{ moment(goodsPackaging.packageTime).format('YYYY-MM-DD')}</Description> 
<Description term="描述">{goodsPackaging.description}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = goodsPackaging => {
  const {GoodsPackagingBase} = GlobalComponents
  return <PermissionSetting targetObject={goodsPackaging}  targetObjectMeta={GoodsPackagingBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class GoodsPackagingPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  goodsPackaging = this.props.goodsPackaging
    const { id,displayName, goodsCount } = goodsPackaging
    const  returnURL = `/goodsPackaging/${id}/dashboard`
    const cardsData = {cardsName:"货物包装",cardsFor: "goodsPackaging",cardsSource: goodsPackaging,displayName,returnURL,
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
  goodsPackaging: state._goodsPackaging,
}))(Form.create()(GoodsPackagingPermission))


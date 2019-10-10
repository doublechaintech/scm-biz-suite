

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './RetailStoreOrderLineItem.profile.less'
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
const internalSummaryOf = (retailStoreOrderLineItem,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreOrderLineItem.id}</Description> 
<Description term="产品ID">{retailStoreOrderLineItem.skuId}</Description> 
<Description term="产品名称">{retailStoreOrderLineItem.skuName}</Description> 
<Description term="金额">{retailStoreOrderLineItem.amount}</Description> 
<Description term="数量">{retailStoreOrderLineItem.quantity}</Description> 
<Description term="测量单位">{retailStoreOrderLineItem.unitOfMeasurement}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = retailStoreOrderLineItem => {
  const {RetailStoreOrderLineItemBase} = GlobalComponents
  return <PermissionSetting targetObject={retailStoreOrderLineItem}  targetObjectMeta={RetailStoreOrderLineItemBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class RetailStoreOrderLineItemPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  retailStoreOrderLineItem = this.props.retailStoreOrderLineItem
    const { id,displayName,  } = retailStoreOrderLineItem
    const  returnURL = `/retailStoreOrderLineItem/${id}/dashboard`
    const cardsData = {cardsName:"双链小超订单行项目",cardsFor: "retailStoreOrderLineItem",cardsSource: retailStoreOrderLineItem,displayName,returnURL,
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
  retailStoreOrderLineItem: state._retailStoreOrderLineItem,
}))(Form.create()(RetailStoreOrderLineItemPermission))


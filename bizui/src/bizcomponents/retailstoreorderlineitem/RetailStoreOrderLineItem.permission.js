

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
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


const internalSummaryOf = (retailStoreOrderLineItem,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{retailStoreOrderLineItem.id}</Description> 
<Description term="Sku Id">{retailStoreOrderLineItem.skuId}</Description> 
<Description term="Sku Name">{retailStoreOrderLineItem.skuName}</Description> 
<Description term="Amount">{retailStoreOrderLineItem.amount}</Description> 
<Description term="Quantity">{retailStoreOrderLineItem.quantity}</Description> 
<Description term="Unit Of Measurement">{retailStoreOrderLineItem.unitOfMeasurement}</Description> 
	
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
    const  retailStoreOrderLineItem = this.props.retailStoreOrderLineItem;
    const { id,displayName,  } = retailStoreOrderLineItem
    const cardsData = {cardsName:"Retail Store Order Line Item",cardsFor: "retailStoreOrderLineItem",cardsSource: retailStoreOrderLineItem,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
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


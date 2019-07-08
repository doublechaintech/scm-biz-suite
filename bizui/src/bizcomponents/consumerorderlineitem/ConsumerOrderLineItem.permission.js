

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
import styles from './ConsumerOrderLineItem.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (consumerOrderLineItem,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{consumerOrderLineItem.id}</Description> 
<Description term="Sku Id">{consumerOrderLineItem.skuId}</Description> 
<Description term="Sku Name">{consumerOrderLineItem.skuName}</Description> 
<Description term="Price">{consumerOrderLineItem.price}</Description> 
<Description term="Quantity">{consumerOrderLineItem.quantity}</Description> 
<Description term="Amount">{consumerOrderLineItem.amount}</Description> 
<Description term="Last Update Time">{ moment(consumerOrderLineItem.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = consumerOrderLineItem => {
  const {ConsumerOrderLineItemBase} = GlobalComponents
  return <PermissionSetting targetObject={consumerOrderLineItem}  targetObjectMeta={ConsumerOrderLineItemBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class ConsumerOrderLineItemPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  consumerOrderLineItem = this.props.consumerOrderLineItem;
    const { id,displayName,  } = consumerOrderLineItem
    const cardsData = {cardsName:"Consumer Order Line Item",cardsFor: "consumerOrderLineItem",cardsSource: consumerOrderLineItem,
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
  consumerOrderLineItem: state._consumerOrderLineItem,
}))(Form.create()(ConsumerOrderLineItemPermission))


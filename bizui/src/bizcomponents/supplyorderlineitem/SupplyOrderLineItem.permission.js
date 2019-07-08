

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
import styles from './SupplyOrderLineItem.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (supplyOrderLineItem,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{supplyOrderLineItem.id}</Description> 
<Description term="Sku Id">{supplyOrderLineItem.skuId}</Description> 
<Description term="Sku Name">{supplyOrderLineItem.skuName}</Description> 
<Description term="Amount">{supplyOrderLineItem.amount}</Description> 
<Description term="Quantity">{supplyOrderLineItem.quantity}</Description> 
<Description term="Unit Of Measurement">{supplyOrderLineItem.unitOfMeasurement}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = supplyOrderLineItem => {
  const {SupplyOrderLineItemBase} = GlobalComponents
  return <PermissionSetting targetObject={supplyOrderLineItem}  targetObjectMeta={SupplyOrderLineItemBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class SupplyOrderLineItemPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  supplyOrderLineItem = this.props.supplyOrderLineItem;
    const { id,displayName,  } = supplyOrderLineItem
    const cardsData = {cardsName:"Supply Order Line Item",cardsFor: "supplyOrderLineItem",cardsSource: supplyOrderLineItem,
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
  supplyOrderLineItem: state._supplyOrderLineItem,
}))(Form.create()(SupplyOrderLineItemPermission))


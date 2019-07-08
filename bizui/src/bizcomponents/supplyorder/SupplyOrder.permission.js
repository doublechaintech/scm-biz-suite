

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
import styles from './SupplyOrder.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (supplyOrder,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{supplyOrder.id}</Description> 
<Description term="Title">{supplyOrder.title}</Description> 
<Description term="Total Amount">{supplyOrder.totalAmount}</Description> 
<Description term="Last Update Time">{ moment(supplyOrder.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
<Description term="Current Status">{supplyOrder.currentStatus}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = supplyOrder => {
  const {SupplyOrderBase} = GlobalComponents
  return <PermissionSetting targetObject={supplyOrder}  targetObjectMeta={SupplyOrderBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class SupplyOrderPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  supplyOrder = this.props.supplyOrder;
    const { id,displayName, supplyOrderLineItemCount, supplyOrderShippingGroupCount, supplyOrderPaymentGroupCount, goodsCount } = supplyOrder
    const cardsData = {cardsName:"Supply Order",cardsFor: "supplyOrder",cardsSource: supplyOrder,
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
  supplyOrder: state._supplyOrder,
}))(Form.create()(SupplyOrderPermission))


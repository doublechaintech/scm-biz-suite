

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
import styles from './ConsumerOrder.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (consumerOrder,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{consumerOrder.id}</Description> 
<Description term="Title">{consumerOrder.title}</Description> 
<Description term="Last Update Time">{ moment(consumerOrder.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
<Description term="Current Status">{consumerOrder.currentStatus}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = consumerOrder => {
  const {ConsumerOrderBase} = GlobalComponents
  return <PermissionSetting targetObject={consumerOrder}  targetObjectMeta={ConsumerOrderBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class ConsumerOrderPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  consumerOrder = this.props.consumerOrder;
    const { id,displayName, consumerOrderLineItemCount, consumerOrderShippingGroupCount, consumerOrderPaymentGroupCount, consumerOrderPriceAdjustmentCount, retailStoreMemberGiftCardConsumeRecordCount } = consumerOrder
    const cardsData = {cardsName:"Consumer Order",cardsFor: "consumerOrder",cardsSource: consumerOrder,
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
  consumerOrder: state._consumerOrder,
}))(Form.create()(ConsumerOrderPermission))


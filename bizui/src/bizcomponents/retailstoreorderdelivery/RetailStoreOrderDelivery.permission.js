

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
import styles from './RetailStoreOrderDelivery.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (retailStoreOrderDelivery,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{retailStoreOrderDelivery.id}</Description> 
<Description term="Who">{retailStoreOrderDelivery.who}</Description> 
<Description term="Delivery Time">{ moment(retailStoreOrderDelivery.deliveryTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = retailStoreOrderDelivery => {
  const {RetailStoreOrderDeliveryBase} = GlobalComponents
  return <PermissionSetting targetObject={retailStoreOrderDelivery}  targetObjectMeta={RetailStoreOrderDeliveryBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class RetailStoreOrderDeliveryPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  retailStoreOrderDelivery = this.props.retailStoreOrderDelivery;
    const { id,displayName, retailStoreOrderCount } = retailStoreOrderDelivery
    const cardsData = {cardsName:"Retail Store Order Delivery",cardsFor: "retailStoreOrderDelivery",cardsSource: retailStoreOrderDelivery,
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
  retailStoreOrderDelivery: state._retailStoreOrderDelivery,
}))(Form.create()(RetailStoreOrderDeliveryPermission))


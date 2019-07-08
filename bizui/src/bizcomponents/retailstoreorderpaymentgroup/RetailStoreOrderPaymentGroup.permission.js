

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
import styles from './RetailStoreOrderPaymentGroup.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (retailStoreOrderPaymentGroup,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{retailStoreOrderPaymentGroup.id}</Description> 
<Description term="Name">{retailStoreOrderPaymentGroup.name}</Description> 
<Description term="Card Number">{retailStoreOrderPaymentGroup.cardNumber}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = retailStoreOrderPaymentGroup => {
  const {RetailStoreOrderPaymentGroupBase} = GlobalComponents
  return <PermissionSetting targetObject={retailStoreOrderPaymentGroup}  targetObjectMeta={RetailStoreOrderPaymentGroupBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class RetailStoreOrderPaymentGroupPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  retailStoreOrderPaymentGroup = this.props.retailStoreOrderPaymentGroup;
    const { id,displayName,  } = retailStoreOrderPaymentGroup
    const cardsData = {cardsName:"Retail Store Order Payment Group",cardsFor: "retailStoreOrderPaymentGroup",cardsSource: retailStoreOrderPaymentGroup,
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
  retailStoreOrderPaymentGroup: state._retailStoreOrderPaymentGroup,
}))(Form.create()(RetailStoreOrderPaymentGroupPermission))


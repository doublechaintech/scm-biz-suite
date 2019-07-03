

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
import styles from './RetailStoreOrderShippingGroup.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (retailStoreOrderShippingGroup,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreOrderShippingGroup.id}</Description> 
<Description term="名称">{retailStoreOrderShippingGroup.name}</Description> 
<Description term="金额">{retailStoreOrderShippingGroup.amount}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = retailStoreOrderShippingGroup => {
  const {RetailStoreOrderShippingGroupBase} = GlobalComponents
  return <PermissionSetting targetObject={retailStoreOrderShippingGroup}  targetObjectMeta={RetailStoreOrderShippingGroupBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class RetailStoreOrderShippingGroupPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  retailStoreOrderShippingGroup = this.props.retailStoreOrderShippingGroup;
    const { id,displayName,  } = retailStoreOrderShippingGroup
    const cardsData = {cardsName:"生超订单送货分组",cardsFor: "retailStoreOrderShippingGroup",cardsSource: retailStoreOrderShippingGroup,
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
  retailStoreOrderShippingGroup: state._retailStoreOrderShippingGroup,
}))(Form.create()(RetailStoreOrderShippingGroupPermission))


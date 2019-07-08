

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
import styles from './SupplyOrderPaymentGroup.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (supplyOrderPaymentGroup,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{supplyOrderPaymentGroup.id}</Description> 
<Description term="Name">{supplyOrderPaymentGroup.name}</Description> 
<Description term="Card Number">{supplyOrderPaymentGroup.cardNumber}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = supplyOrderPaymentGroup => {
  const {SupplyOrderPaymentGroupBase} = GlobalComponents
  return <PermissionSetting targetObject={supplyOrderPaymentGroup}  targetObjectMeta={SupplyOrderPaymentGroupBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class SupplyOrderPaymentGroupPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  supplyOrderPaymentGroup = this.props.supplyOrderPaymentGroup;
    const { id,displayName,  } = supplyOrderPaymentGroup
    const cardsData = {cardsName:"Supply Order Payment Group",cardsFor: "supplyOrderPaymentGroup",cardsSource: supplyOrderPaymentGroup,
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
  supplyOrderPaymentGroup: state._supplyOrderPaymentGroup,
}))(Form.create()(SupplyOrderPaymentGroupPermission))


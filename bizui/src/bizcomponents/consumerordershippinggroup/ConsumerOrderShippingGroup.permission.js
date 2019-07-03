

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
import styles from './ConsumerOrderShippingGroup.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (consumerOrderShippingGroup,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{consumerOrderShippingGroup.id}</Description> 
<Description term="名称">{consumerOrderShippingGroup.name}</Description> 
<Description term="金额">{consumerOrderShippingGroup.amount}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = consumerOrderShippingGroup => {
  const {ConsumerOrderShippingGroupBase} = GlobalComponents
  return <PermissionSetting targetObject={consumerOrderShippingGroup}  targetObjectMeta={ConsumerOrderShippingGroupBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class ConsumerOrderShippingGroupPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  consumerOrderShippingGroup = this.props.consumerOrderShippingGroup;
    const { id,displayName,  } = consumerOrderShippingGroup
    const cardsData = {cardsName:"消费订单送货分组",cardsFor: "consumerOrderShippingGroup",cardsSource: consumerOrderShippingGroup,
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
  consumerOrderShippingGroup: state._consumerOrderShippingGroup,
}))(Form.create()(ConsumerOrderShippingGroupPermission))


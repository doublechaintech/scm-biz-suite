

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
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

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (consumerOrderLineItem,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{consumerOrderLineItem.id}</Description> 
<Description term="产品ID">{consumerOrderLineItem.skuId}</Description> 
<Description term="产品名称">{consumerOrderLineItem.skuName}</Description> 
<Description term="价格">{consumerOrderLineItem.price}</Description> 
<Description term="数量">{consumerOrderLineItem.quantity}</Description> 
<Description term="金额">{consumerOrderLineItem.amount}</Description> 
<Description term="更新于">{ moment(consumerOrderLineItem.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
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
    const  consumerOrderLineItem = this.props.consumerOrderLineItem
    const { id,displayName,  } = consumerOrderLineItem
    const  returnURL = `/consumerOrderLineItem/${id}/workbench`
    const cardsData = {cardsName:"消费者订单行项目",cardsFor: "consumerOrderLineItem",cardsSource: consumerOrderLineItem,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
       
        wrapperClassName={styles.advancedForm}
      >
      
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  consumerOrderLineItem: state._consumerOrderLineItem,
}))(Form.create()(ConsumerOrderLineItemPermission))


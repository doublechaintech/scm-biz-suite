

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './ConsumerOrderPriceAdjustment.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (consumerOrderPriceAdjustment,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{consumerOrderPriceAdjustment.id}</Description> 
<Description term="名称">{consumerOrderPriceAdjustment.name}</Description> 
<Description term="金额">{consumerOrderPriceAdjustment.amount}</Description> 
<Description term="供应商">{consumerOrderPriceAdjustment.provider}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = consumerOrderPriceAdjustment => {
  const {ConsumerOrderPriceAdjustmentBase} = GlobalComponents
  return <PermissionSetting targetObject={consumerOrderPriceAdjustment}  targetObjectMeta={ConsumerOrderPriceAdjustmentBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class ConsumerOrderPriceAdjustmentPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  consumerOrderPriceAdjustment = this.props.consumerOrderPriceAdjustment
    const { id,displayName,  } = consumerOrderPriceAdjustment
    const  returnURL = `/consumerOrderPriceAdjustment/${id}/dashboard`
    const cardsData = {cardsName:"消费品价格调整",cardsFor: "consumerOrderPriceAdjustment",cardsSource: consumerOrderPriceAdjustment,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
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
  consumerOrderPriceAdjustment: state._consumerOrderPriceAdjustment,
}))(Form.create()(ConsumerOrderPriceAdjustmentPermission))


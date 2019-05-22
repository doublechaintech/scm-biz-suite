

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'

import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './SupplyOrderLineItem.preference.less'
import DescriptionList from '../../components/DescriptionList';

import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {
  defaultRenderExtraHeader,
  defaultSubListsOf,

}= DashboardTool

const { Description } = DescriptionList;

const internalRenderExtraHeader = defaultRenderExtraHeader

const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (supplyOrderLineItem,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{supplyOrderLineItem.id}</Description> 
<Description term="产品ID">{supplyOrderLineItem.skuId}</Description> 
<Description term="产品名称">{supplyOrderLineItem.skuName}</Description> 
<Description term="金额">{supplyOrderLineItem.amount}</Description> 
<Description term="数量">{supplyOrderLineItem.quantity}</Description> 
<Description term="测量单位">{supplyOrderLineItem.unitOfMeasurement}</Description> 
	
      </DescriptionList>
	)
}



class SupplyOrderLineItemProfile extends Component {

  
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  supplyOrderLineItem = this.props.supplyOrderLineItem;
    const { id,displayName,  } = supplyOrderLineItem

    const cardsData = {cardsName:"供应订单行项目",cardsFor: "supplyOrderLineItem",cardsSource: supplyOrderLineItem,
  		subItems: [
    
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
       {subListsOf(cardsData)} 
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  supplyOrderLineItem: state._supplyOrderLineItem,
}))(Form.create()(SupplyOrderLineItemProfile))


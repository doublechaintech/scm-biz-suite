

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'

import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './SupplyOrder.preference.less'
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


const internalSummaryOf = (supplyOrder,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{supplyOrder.id}</Description> 
<Description term="头衔">{supplyOrder.title}</Description> 
<Description term="总金额">{supplyOrder.totalAmount}</Description> 
<Description term="最后更新时间">{ moment(supplyOrder.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
<Description term="当前状态">{supplyOrder.currentStatus}</Description> 
	
      </DescriptionList>
	)
}



class SupplyOrderProfile extends Component {

  
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  supplyOrder = this.props.supplyOrder;
    const { id,displayName, supplyOrderLineItemCount, supplyOrderShippingGroupCount, supplyOrderPaymentGroupCount, goodsCount } = supplyOrder

    const cardsData = {cardsName:"供应订单",cardsFor: "supplyOrder",cardsSource: supplyOrder,
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
  supplyOrder: state._supplyOrder,
}))(Form.create()(SupplyOrderProfile))


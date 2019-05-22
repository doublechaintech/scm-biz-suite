

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'

import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './RetailStoreOrderPaymentGroup.preference.less'
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


const internalSummaryOf = (retailStoreOrderPaymentGroup,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreOrderPaymentGroup.id}</Description> 
<Description term="名称">{retailStoreOrderPaymentGroup.name}</Description> 
<Description term="卡号码">{retailStoreOrderPaymentGroup.cardNumber}</Description> 
	
      </DescriptionList>
	)
}



class RetailStoreOrderPaymentGroupProfile extends Component {

  
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  retailStoreOrderPaymentGroup = this.props.retailStoreOrderPaymentGroup;
    const { id,displayName,  } = retailStoreOrderPaymentGroup

    const cardsData = {cardsName:"生超订单付款组",cardsFor: "retailStoreOrderPaymentGroup",cardsSource: retailStoreOrderPaymentGroup,
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
  retailStoreOrderPaymentGroup: state._retailStoreOrderPaymentGroup,
}))(Form.create()(RetailStoreOrderPaymentGroupProfile))


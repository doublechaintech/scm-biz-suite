

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'

import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './RetailStoreMemberGiftCard.preference.less'
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


const internalSummaryOf = (retailStoreMemberGiftCard,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreMemberGiftCard.id}</Description> 
<Description term="名称">{retailStoreMemberGiftCard.name}</Description> 
<Description term="数">{retailStoreMemberGiftCard.number}</Description> 
<Description term="保持">{retailStoreMemberGiftCard.remain}</Description> 
	
      </DescriptionList>
	)
}



class RetailStoreMemberGiftCardProfile extends Component {

  
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  retailStoreMemberGiftCard = this.props.retailStoreMemberGiftCard;
    const { id,displayName, retailStoreMemberGiftCardConsumeRecordCount } = retailStoreMemberGiftCard

    const cardsData = {cardsName:"零售店会员礼品卡",cardsFor: "retailStoreMemberGiftCard",cardsSource: retailStoreMemberGiftCard,
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
  retailStoreMemberGiftCard: state._retailStoreMemberGiftCard,
}))(Form.create()(RetailStoreMemberGiftCardProfile))


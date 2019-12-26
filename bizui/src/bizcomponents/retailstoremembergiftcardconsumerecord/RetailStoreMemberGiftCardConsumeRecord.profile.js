

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import GlobalComponents from '../../custcomponents';
import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './RetailStoreMemberGiftCardConsumeRecord.profile.less'
import DescriptionList from '../../components/DescriptionList';

import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {
  defaultRenderExtraHeader,
  defaultSubListsOf, defaultRenderSettingList,

}= DashboardTool

const { Description } = DescriptionList;

const internalRenderExtraHeader = defaultRenderExtraHeader

const internalSubListsOf = defaultSubListsOf

const internalRenderSettingList = defaultRenderSettingList

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}

const internalSummaryOf = (item, targetComponents)=>{
	
	return GlobalComponents.RetailStoreMemberGiftCardConsumeRecordBase.renderItemOfList(item, targetComponents)

}



class RetailStoreMemberGiftCardConsumeRecordProfile extends Component {

  
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  retailStoreMemberGiftCardConsumeRecord = this.props.retailStoreMemberGiftCardConsumeRecord;
    const { id,displayName,  } = retailStoreMemberGiftCardConsumeRecord
    const  returnURL = `/retailStoreMemberGiftCardConsumeRecord/${id}/dashboard`
<<<<<<< HEAD
    const cardsData = {cardsName:"零售商店会员卡消费记录",cardsFor: "retailStoreMemberGiftCardConsumeRecord",cardsSource: retailStoreMemberGiftCardConsumeRecord,displayName,returnURL,
=======
    const cardsData = {cardsName:"零售门店会员卡消费记录",cardsFor: "retailStoreMemberGiftCardConsumeRecord",cardsSource: retailStoreMemberGiftCardConsumeRecord,displayName,returnURL,
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
     
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
   
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderSettingList = this.props.renderSettingList || internalRenderSettingList
    
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData, this)}
        content={summaryOf(cardsData.cardsSource, this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
       {renderSettingList(cardsData)} 
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  retailStoreMemberGiftCardConsumeRecord: state._retailStoreMemberGiftCardConsumeRecord,
}))(Form.create()(RetailStoreMemberGiftCardConsumeRecordProfile))


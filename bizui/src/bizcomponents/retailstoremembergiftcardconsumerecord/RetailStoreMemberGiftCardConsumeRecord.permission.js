

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
import styles from './RetailStoreMemberGiftCardConsumeRecord.profile.less'
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
const internalSummaryOf = (retailStoreMemberGiftCardConsumeRecord,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreMemberGiftCardConsumeRecord.id}</Description> 
<Description term="发生时间">{ moment(retailStoreMemberGiftCardConsumeRecord.occureTime).format('YYYY-MM-DD')}</Description> 
<Description term="数">{retailStoreMemberGiftCardConsumeRecord.number}</Description> 
<Description term="金额">{retailStoreMemberGiftCardConsumeRecord.amount}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = retailStoreMemberGiftCardConsumeRecord => {
  const {RetailStoreMemberGiftCardConsumeRecordBase} = GlobalComponents
  return <PermissionSetting targetObject={retailStoreMemberGiftCardConsumeRecord}  targetObjectMeta={RetailStoreMemberGiftCardConsumeRecordBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class RetailStoreMemberGiftCardConsumeRecordPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  retailStoreMemberGiftCardConsumeRecord = this.props.retailStoreMemberGiftCardConsumeRecord
    const { id,displayName,  } = retailStoreMemberGiftCardConsumeRecord
    const  returnURL = `/retailStoreMemberGiftCardConsumeRecord/${id}/dashboard`
    const cardsData = {cardsName:"零售商店会员卡消费记录",cardsFor: "retailStoreMemberGiftCardConsumeRecord",cardsSource: retailStoreMemberGiftCardConsumeRecord,displayName,returnURL,
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
  retailStoreMemberGiftCardConsumeRecord: state._retailStoreMemberGiftCardConsumeRecord,
}))(Form.create()(RetailStoreMemberGiftCardConsumeRecordPermission))


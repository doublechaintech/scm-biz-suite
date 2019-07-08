

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
import styles from './RetailStoreMemberGiftCardConsumeRecord.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (retailStoreMemberGiftCardConsumeRecord,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{retailStoreMemberGiftCardConsumeRecord.id}</Description> 
<Description term="Occure Time">{ moment(retailStoreMemberGiftCardConsumeRecord.occureTime).format('YYYY-MM-DD')}</Description> 
<Description term="Number">{retailStoreMemberGiftCardConsumeRecord.number}</Description> 
<Description term="Amount">{retailStoreMemberGiftCardConsumeRecord.amount}</Description> 
	
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
    const  retailStoreMemberGiftCardConsumeRecord = this.props.retailStoreMemberGiftCardConsumeRecord;
    const { id,displayName,  } = retailStoreMemberGiftCardConsumeRecord
    const cardsData = {cardsName:"Retail Store Member Gift Card Consume Record",cardsFor: "retailStoreMemberGiftCardConsumeRecord",cardsSource: retailStoreMemberGiftCardConsumeRecord,
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
  retailStoreMemberGiftCardConsumeRecord: state._retailStoreMemberGiftCardConsumeRecord,
}))(Form.create()(RetailStoreMemberGiftCardConsumeRecordPermission))




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
import styles from './AccountingSubject.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (accountingSubject,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{accountingSubject.id}</Description> 
<Description term="Accounting Subject Code">{accountingSubject.accountingSubjectCode}</Description> 
<Description term="Accounting Subject Name">{accountingSubject.accountingSubjectName}</Description> 
<Description term="Accounting Subject Class Code">{accountingSubject.accountingSubjectClassCode}</Description> 
<Description term="Accounting Subject Class Name">{accountingSubject.accountingSubjectClassName}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = accountingSubject => {
  const {AccountingSubjectBase} = GlobalComponents
  return <PermissionSetting targetObject={accountingSubject}  targetObjectMeta={AccountingSubjectBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class AccountingSubjectPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  accountingSubject = this.props.accountingSubject;
    const { id,displayName, accountingDocumentLineCount } = accountingSubject
    const cardsData = {cardsName:"Accounting Subject",cardsFor: "accountingSubject",cardsSource: accountingSubject,
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
  accountingSubject: state._accountingSubject,
}))(Form.create()(AccountingSubjectPermission))


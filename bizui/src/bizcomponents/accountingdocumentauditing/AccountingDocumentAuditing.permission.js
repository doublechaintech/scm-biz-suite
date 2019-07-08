

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
import styles from './AccountingDocumentAuditing.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (accountingDocumentAuditing,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{accountingDocumentAuditing.id}</Description> 
<Description term="Who">{accountingDocumentAuditing.who}</Description> 
<Description term="Comments">{accountingDocumentAuditing.comments}</Description> 
<Description term="Make Date">{ moment(accountingDocumentAuditing.makeDate).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = accountingDocumentAuditing => {
  const {AccountingDocumentAuditingBase} = GlobalComponents
  return <PermissionSetting targetObject={accountingDocumentAuditing}  targetObjectMeta={AccountingDocumentAuditingBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class AccountingDocumentAuditingPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  accountingDocumentAuditing = this.props.accountingDocumentAuditing;
    const { id,displayName, accountingDocumentCount } = accountingDocumentAuditing
    const cardsData = {cardsName:"Accounting Document Auditing",cardsFor: "accountingDocumentAuditing",cardsSource: accountingDocumentAuditing,
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
  accountingDocumentAuditing: state._accountingDocumentAuditing,
}))(Form.create()(AccountingDocumentAuditingPermission))


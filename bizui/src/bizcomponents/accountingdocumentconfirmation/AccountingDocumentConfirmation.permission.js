

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
import styles from './AccountingDocumentConfirmation.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (accountingDocumentConfirmation,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{accountingDocumentConfirmation.id}</Description> 
<Description term="Who">{accountingDocumentConfirmation.who}</Description> 
<Description term="Comments">{accountingDocumentConfirmation.comments}</Description> 
<Description term="Make Date">{ moment(accountingDocumentConfirmation.makeDate).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = accountingDocumentConfirmation => {
  const {AccountingDocumentConfirmationBase} = GlobalComponents
  return <PermissionSetting targetObject={accountingDocumentConfirmation}  targetObjectMeta={AccountingDocumentConfirmationBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class AccountingDocumentConfirmationPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  accountingDocumentConfirmation = this.props.accountingDocumentConfirmation;
    const { id,displayName, accountingDocumentCount } = accountingDocumentConfirmation
    const cardsData = {cardsName:"Accounting Document Confirmation",cardsFor: "accountingDocumentConfirmation",cardsSource: accountingDocumentConfirmation,
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
  accountingDocumentConfirmation: state._accountingDocumentConfirmation,
}))(Form.create()(AccountingDocumentConfirmationPermission))


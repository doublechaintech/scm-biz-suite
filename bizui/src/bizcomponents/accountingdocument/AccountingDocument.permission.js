

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
import styles from './AccountingDocument.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (accountingDocument,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{accountingDocument.id}</Description> 
<Description term="Name">{accountingDocument.name}</Description> 
<Description term="Accounting Document Date">{ moment(accountingDocument.accountingDocumentDate).format('YYYY-MM-DD')}</Description> 
<Description term="Current Status">{accountingDocument.currentStatus}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = accountingDocument => {
  const {AccountingDocumentBase} = GlobalComponents
  return <PermissionSetting targetObject={accountingDocument}  targetObjectMeta={AccountingDocumentBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class AccountingDocumentPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  accountingDocument = this.props.accountingDocument;
    const { id,displayName, originalVoucherCount, accountingDocumentLineCount } = accountingDocument
    const cardsData = {cardsName:"Accounting Document",cardsFor: "accountingDocument",cardsSource: accountingDocument,
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
  accountingDocument: state._accountingDocument,
}))(Form.create()(AccountingDocumentPermission))




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
import styles from './AccountingDocumentPosting.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (accountingDocumentPosting,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{accountingDocumentPosting.id}</Description> 
<Description term="Who">{accountingDocumentPosting.who}</Description> 
<Description term="Comments">{accountingDocumentPosting.comments}</Description> 
<Description term="Make Date">{ moment(accountingDocumentPosting.makeDate).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = accountingDocumentPosting => {
  const {AccountingDocumentPostingBase} = GlobalComponents
  return <PermissionSetting targetObject={accountingDocumentPosting}  targetObjectMeta={AccountingDocumentPostingBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class AccountingDocumentPostingPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  accountingDocumentPosting = this.props.accountingDocumentPosting;
    const { id,displayName, accountingDocumentCount } = accountingDocumentPosting
    const cardsData = {cardsName:"Accounting Document Posting",cardsFor: "accountingDocumentPosting",cardsSource: accountingDocumentPosting,
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
  accountingDocumentPosting: state._accountingDocumentPosting,
}))(Form.create()(AccountingDocumentPostingPermission))


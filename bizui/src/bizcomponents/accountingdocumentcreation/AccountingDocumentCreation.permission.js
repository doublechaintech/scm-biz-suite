

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
import styles from './AccountingDocumentCreation.profile.less'
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
const internalSummaryOf = (accountingDocumentCreation,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{accountingDocumentCreation.id}</Description> 
<Description term="谁">{accountingDocumentCreation.who}</Description> 
<Description term="评论">{accountingDocumentCreation.comments}</Description> 
<Description term="制造日期">{ moment(accountingDocumentCreation.makeDate).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = accountingDocumentCreation => {
  const {AccountingDocumentCreationBase} = GlobalComponents
  return <PermissionSetting targetObject={accountingDocumentCreation}  targetObjectMeta={AccountingDocumentCreationBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class AccountingDocumentCreationPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  accountingDocumentCreation = this.props.accountingDocumentCreation
    const { id,displayName, accountingDocumentCount } = accountingDocumentCreation
    const  returnURL = `/accountingDocumentCreation/${id}/dashboard`
    const cardsData = {cardsName:"会计文件的创建",cardsFor: "accountingDocumentCreation",cardsSource: accountingDocumentCreation,displayName,returnURL,
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
  accountingDocumentCreation: state._accountingDocumentCreation,
}))(Form.create()(AccountingDocumentCreationPermission))


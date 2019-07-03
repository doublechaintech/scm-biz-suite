

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
import styles from './AccountingDocumentLine.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (accountingDocumentLine,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{accountingDocumentLine.id}</Description> 
<Description term="名称">{accountingDocumentLine.name}</Description> 
<Description term="代码">{accountingDocumentLine.code}</Description> 
<Description term="直接">{accountingDocumentLine.direct}</Description> 
<Description term="金额">{accountingDocumentLine.amount}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = accountingDocumentLine => {
  const {AccountingDocumentLineBase} = GlobalComponents
  return <PermissionSetting targetObject={accountingDocumentLine}  targetObjectMeta={AccountingDocumentLineBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class AccountingDocumentLinePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  accountingDocumentLine = this.props.accountingDocumentLine;
    const { id,displayName,  } = accountingDocumentLine
    const cardsData = {cardsName:"会计凭证行",cardsFor: "accountingDocumentLine",cardsSource: accountingDocumentLine,
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
  accountingDocumentLine: state._accountingDocumentLine,
}))(Form.create()(AccountingDocumentLinePermission))


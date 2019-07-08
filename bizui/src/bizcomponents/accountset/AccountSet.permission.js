

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
import styles from './AccountSet.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (accountSet,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{accountSet.id}</Description> 
<Description term="Name">{accountSet.name}</Description> 
<Description term="Year Set">{accountSet.yearSet}</Description> 
<Description term="Effective Date">{ moment(accountSet.effectiveDate).format('YYYY-MM-DD')}</Description> 
<Description term="Accounting System">{accountSet.accountingSystem}</Description> 
<Description term="Domestic Currency Code">{accountSet.domesticCurrencyCode}</Description> 
<Description term="Domestic Currency Name">{accountSet.domesticCurrencyName}</Description> 
<Description term="Opening Bank">{accountSet.openingBank}</Description> 
<Description term="Account Number">{accountSet.accountNumber}</Description> 
<Description term="Last Update Time">{ moment(accountSet.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = accountSet => {
  const {AccountSetBase} = GlobalComponents
  return <PermissionSetting targetObject={accountSet}  targetObjectMeta={AccountSetBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class AccountSetPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  accountSet = this.props.accountSet;
    const { id,displayName, accountingSubjectCount, accountingPeriodCount, accountingDocumentTypeCount } = accountSet
    const cardsData = {cardsName:"Account Set",cardsFor: "accountSet",cardsSource: accountSet,
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
  accountSet: state._accountSet,
}))(Form.create()(AccountSetPermission))


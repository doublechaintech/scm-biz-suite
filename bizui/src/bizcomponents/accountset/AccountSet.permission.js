

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
import styles from './AccountSet.profile.less'
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
const internalSummaryOf = (accountSet,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{accountSet.id}</Description> 
<Description term="名称">{accountSet.name}</Description> 
<Description term="年组">{accountSet.yearSet}</Description> 
<Description term="生效日期">{ moment(accountSet.effectiveDate).format('YYYY-MM-DD')}</Description> 
<Description term="会计制度">{accountSet.accountingSystem}</Description> 
<Description term="本币代码">{accountSet.domesticCurrencyCode}</Description> 
<Description term="本币名称">{accountSet.domesticCurrencyName}</Description> 
<Description term="开户银行">{accountSet.openingBank}</Description> 
<Description term="帐户号码">{accountSet.accountNumber}</Description> 
<Description term="最后更新时间">{ moment(accountSet.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
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
    const  accountSet = this.props.accountSet
    const { id,displayName, accountingSubjectCount, accountingPeriodCount, accountingDocumentTypeCount } = accountSet
    const  returnURL = `/accountSet/${id}/dashboard`
    const cardsData = {cardsName:"账套",cardsFor: "accountSet",cardsSource: accountSet,displayName,returnURL,
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
  accountSet: state._accountSet,
}))(Form.create()(AccountSetPermission))




import React, { Component } from 'react'
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
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (accountSet,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{accountSet.id}</Description> 
<Description term="名称">{accountSet.name}</Description> 
<Description term="年组">{accountSet.yearSet}</Description> 
<Description term="生效日期">{ moment(accountSet.effectiveDate).format('YYYY-MM-DD')}</Description> 
<Description term="会计制度">{accountSet.accountingSystem}</Description> 
<Description term="本币代码">{accountSet.domesticCurrencyCode}</Description> 
<Description term="本币名称">{accountSet.domesticCurrencyName}</Description> 
<Description term="开户银行">{accountSet.openingBank}</Description> 
<Description term="帐户号码">{accountSet.accountNumber}</Description> 
<Description term="更新于">{ moment(accountSet.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
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
    const  returnURL = `/accountSet/${id}/workbench`
    const cardsData = {cardsName:"账套",cardsFor: "accountSet",cardsSource: accountSet,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
       
        wrapperClassName={styles.advancedForm}
      >
      
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  accountSet: state._accountSet,
}))(Form.create()(AccountSetPermission))


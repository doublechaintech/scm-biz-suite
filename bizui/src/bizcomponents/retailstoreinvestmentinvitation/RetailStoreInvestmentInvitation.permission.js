

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
import styles from './RetailStoreInvestmentInvitation.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (retailStoreInvestmentInvitation,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{retailStoreInvestmentInvitation.id}</Description> 
<Description term="Comment">{retailStoreInvestmentInvitation.comment}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = retailStoreInvestmentInvitation => {
  const {RetailStoreInvestmentInvitationBase} = GlobalComponents
  return <PermissionSetting targetObject={retailStoreInvestmentInvitation}  targetObjectMeta={RetailStoreInvestmentInvitationBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class RetailStoreInvestmentInvitationPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  retailStoreInvestmentInvitation = this.props.retailStoreInvestmentInvitation;
    const { id,displayName, retailStoreCount } = retailStoreInvestmentInvitation
    const cardsData = {cardsName:"Retail Store Investment Invitation",cardsFor: "retailStoreInvestmentInvitation",cardsSource: retailStoreInvestmentInvitation,
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
  retailStoreInvestmentInvitation: state._retailStoreInvestmentInvitation,
}))(Form.create()(RetailStoreInvestmentInvitationPermission))


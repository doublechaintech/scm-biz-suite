

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
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

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (retailStoreInvestmentInvitation,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{retailStoreInvestmentInvitation.id}</Description> 
<Description term="评论">{retailStoreInvestmentInvitation.comment}</Description> 
	
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
    const  retailStoreInvestmentInvitation = this.props.retailStoreInvestmentInvitation
    const { id,displayName, retailStoreCount } = retailStoreInvestmentInvitation
    const  returnURL = `/retailStoreInvestmentInvitation/${id}/workbench`
    const cardsData = {cardsName:"生超招商",cardsFor: "retailStoreInvestmentInvitation",cardsSource: retailStoreInvestmentInvitation,displayName,returnURL,
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
  retailStoreInvestmentInvitation: state._retailStoreInvestmentInvitation,
}))(Form.create()(RetailStoreInvestmentInvitationPermission))




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
import styles from './OfferApproval.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (offerApproval,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{offerApproval.id}</Description> 
<Description term="Who">{offerApproval.who}</Description> 
<Description term="Approve Time">{ moment(offerApproval.approveTime).format('YYYY-MM-DD')}</Description> 
<Description term="Comments">{offerApproval.comments}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = offerApproval => {
  const {OfferApprovalBase} = GlobalComponents
  return <PermissionSetting targetObject={offerApproval}  targetObjectMeta={OfferApprovalBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class OfferApprovalPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  offerApproval = this.props.offerApproval;
    const { id,displayName, employeeCount } = offerApproval
    const cardsData = {cardsName:"Offer Approval",cardsFor: "offerApproval",cardsSource: offerApproval,
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
  offerApproval: state._offerApproval,
}))(Form.create()(OfferApprovalPermission))


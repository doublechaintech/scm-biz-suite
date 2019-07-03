

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
import styles from './RetailStoreOrderApproval.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (retailStoreOrderApproval,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreOrderApproval.id}</Description> 
<Description term="谁">{retailStoreOrderApproval.who}</Description> 
<Description term="批准时间">{ moment(retailStoreOrderApproval.approveTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = retailStoreOrderApproval => {
  const {RetailStoreOrderApprovalBase} = GlobalComponents
  return <PermissionSetting targetObject={retailStoreOrderApproval}  targetObjectMeta={RetailStoreOrderApprovalBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class RetailStoreOrderApprovalPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  retailStoreOrderApproval = this.props.retailStoreOrderApproval;
    const { id,displayName, retailStoreOrderCount } = retailStoreOrderApproval
    const cardsData = {cardsName:"生超订单批准",cardsFor: "retailStoreOrderApproval",cardsSource: retailStoreOrderApproval,
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
  retailStoreOrderApproval: state._retailStoreOrderApproval,
}))(Form.create()(RetailStoreOrderApprovalPermission))


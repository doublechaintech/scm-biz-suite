

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
import styles from './SupplyOrderApproval.profile.less'
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
const internalSummaryOf = (supplyOrderApproval,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{supplyOrderApproval.id}</Description> 
<Description term="谁">{supplyOrderApproval.who}</Description> 
<Description term="批准时间">{ moment(supplyOrderApproval.approveTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = supplyOrderApproval => {
  const {SupplyOrderApprovalBase} = GlobalComponents
  return <PermissionSetting targetObject={supplyOrderApproval}  targetObjectMeta={SupplyOrderApprovalBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class SupplyOrderApprovalPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  supplyOrderApproval = this.props.supplyOrderApproval
    const { id,displayName, consumerOrderCount, supplyOrderCount } = supplyOrderApproval
    const  returnURL = `/supplyOrderApproval/${id}/dashboard`
    const cardsData = {cardsName:"供应订单审批",cardsFor: "supplyOrderApproval",cardsSource: supplyOrderApproval,displayName,returnURL,
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
  supplyOrderApproval: state._supplyOrderApproval,
}))(Form.create()(SupplyOrderApprovalPermission))


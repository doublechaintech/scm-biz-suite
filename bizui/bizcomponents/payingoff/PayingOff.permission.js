

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './PayingOff.profile.less'
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
const internalSummaryOf = (payingOff,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{payingOff.id}</Description> 
<Description term="谁">{payingOff.who}</Description> 
<Description term="支付时间">{ moment(payingOff.paidTime).format('YYYY-MM-DD')}</Description> 
<Description term="金额">{payingOff.amount}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = payingOff => {
  const {PayingOffBase} = GlobalComponents
  return <PermissionSetting targetObject={payingOff}  targetObjectMeta={PayingOffBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class PayingOffPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  payingOff = this.props.payingOff
    const { id,displayName, employeeSalarySheetCount } = payingOff
    const  returnURL = `/payingOff/${id}/workbench`
    const cardsData = {cardsName:"工资支付",cardsFor: "payingOff",cardsSource: payingOff,displayName,returnURL,
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
  payingOff: state._payingOff,
}))(Form.create()(PayingOffPermission))


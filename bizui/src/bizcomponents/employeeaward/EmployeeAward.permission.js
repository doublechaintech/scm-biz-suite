

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './EmployeeAward.profile.less'
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
const internalSummaryOf = (employeeAward,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{employeeAward.id}</Description> 
<Description term="完成时间">{ moment(employeeAward.completeTime).format('YYYY-MM-DD')}</Description> 
<Description term="类型">{employeeAward.type}</Description> 
<Description term="备注">{employeeAward.remark}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = employeeAward => {
  const {EmployeeAwardBase} = GlobalComponents
  return <PermissionSetting targetObject={employeeAward}  targetObjectMeta={EmployeeAwardBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class EmployeeAwardPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  employeeAward = this.props.employeeAward
    const { id,displayName,  } = employeeAward
    const  returnURL = `/employeeAward/${id}/workbench`
    const cardsData = {cardsName:"员工嘉奖",cardsFor: "employeeAward",cardsSource: employeeAward,displayName,returnURL,
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
  employeeAward: state._employeeAward,
}))(Form.create()(EmployeeAwardPermission))


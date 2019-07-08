

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
import styles from './Employee.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (employee,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{employee.id}</Description> 
<Description term="Title">{employee.title}</Description> 
<Description term="Family Name">{employee.familyName}</Description> 
<Description term="Given Name">{employee.givenName}</Description> 
<Description term="Email">{employee.email}</Description> 
<Description term="City">{employee.city}</Description> 
<Description term="Address">{employee.address}</Description> 
<Description term="Cell Phone">{employee.cellPhone}</Description> 
<Description term="Salary Account">{employee.salaryAccount}</Description> 
<Description term="Last Update Time">{ moment(employee.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
<Description term="Current Status">{employee.currentStatus}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = employee => {
  const {EmployeeBase} = GlobalComponents
  return <PermissionSetting targetObject={employee}  targetObjectMeta={EmployeeBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class EmployeePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  employee = this.props.employee;
    const { id,displayName, employeeCompanyTrainingCount, employeeSkillCount, employeePerformanceCount, employeeWorkExperienceCount, employeeLeaveCount, employeeInterviewCount, employeeAttendanceCount, employeeQualifierCount, employeeEducationCount, employeeAwardCount, employeeSalarySheetCount, payingOffCount } = employee
    const cardsData = {cardsName:"Employee",cardsFor: "employee",cardsSource: employee,
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
  employee: state._employee,
}))(Form.create()(EmployeePermission))


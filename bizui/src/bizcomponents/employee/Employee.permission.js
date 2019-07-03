

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
<Description term="序号">{employee.id}</Description> 
<Description term="头衔">{employee.title}</Description> 
<Description term="姓">{employee.familyName}</Description> 
<Description term="名">{employee.givenName}</Description> 
<Description term="电子邮件">{employee.email}</Description> 
<Description term="城市">{employee.city}</Description> 
<Description term="地址">{employee.address}</Description> 
<Description term="手机">{employee.cellPhone}</Description> 
<Description term="工资账户">{employee.salaryAccount}</Description> 
<Description term="最后更新时间">{ moment(employee.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
<Description term="当前状态">{employee.currentStatus}</Description> 
	
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
    const cardsData = {cardsName:"员工",cardsFor: "employee",cardsSource: employee,
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




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
import styles from './EmployeeSalarySheet.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (employeeSalarySheet,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{employeeSalarySheet.id}</Description> 
<Description term="Base Salary">{employeeSalarySheet.baseSalary}</Description> 
<Description term="Bonus">{employeeSalarySheet.bonus}</Description> 
<Description term="Reward">{employeeSalarySheet.reward}</Description> 
<Description term="Personal Tax">{employeeSalarySheet.personalTax}</Description> 
<Description term="Social Security">{employeeSalarySheet.socialSecurity}</Description> 
<Description term="Housing Found">{employeeSalarySheet.housingFound}</Description> 
<Description term="Job Insurance">{employeeSalarySheet.jobInsurance}</Description> 
<Description term="Current Status">{employeeSalarySheet.currentStatus}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = employeeSalarySheet => {
  const {EmployeeSalarySheetBase} = GlobalComponents
  return <PermissionSetting targetObject={employeeSalarySheet}  targetObjectMeta={EmployeeSalarySheetBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class EmployeeSalarySheetPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  employeeSalarySheet = this.props.employeeSalarySheet;
    const { id,displayName,  } = employeeSalarySheet
    const cardsData = {cardsName:"Employee Salary Sheet",cardsFor: "employeeSalarySheet",cardsSource: employeeSalarySheet,
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
  employeeSalarySheet: state._employeeSalarySheet,
}))(Form.create()(EmployeeSalarySheetPermission))


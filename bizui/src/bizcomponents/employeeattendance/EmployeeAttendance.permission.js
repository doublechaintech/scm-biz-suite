

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
import styles from './EmployeeAttendance.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (employeeAttendance,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{employeeAttendance.id}</Description> 
<Description term="Enter Time">{ moment(employeeAttendance.enterTime).format('YYYY-MM-DD')}</Description> 
<Description term="Leave Time">{ moment(employeeAttendance.leaveTime).format('YYYY-MM-DD')}</Description> 
<Description term="Duration Hours">{employeeAttendance.durationHours}</Description> 
<Description term="Remark">{employeeAttendance.remark}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = employeeAttendance => {
  const {EmployeeAttendanceBase} = GlobalComponents
  return <PermissionSetting targetObject={employeeAttendance}  targetObjectMeta={EmployeeAttendanceBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class EmployeeAttendancePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  employeeAttendance = this.props.employeeAttendance;
    const { id,displayName,  } = employeeAttendance
    const cardsData = {cardsName:"Employee Attendance",cardsFor: "employeeAttendance",cardsSource: employeeAttendance,
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
  employeeAttendance: state._employeeAttendance,
}))(Form.create()(EmployeeAttendancePermission))


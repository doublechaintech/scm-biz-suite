

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
import styles from './RetailStoreCountryCenter.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (retailStoreCountryCenter,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{retailStoreCountryCenter.id}</Description> 
<Description term="Name">{retailStoreCountryCenter.name}</Description> 
<Description term="Service Number">{retailStoreCountryCenter.serviceNumber}</Description> 
<Description term="Founded">{ moment(retailStoreCountryCenter.founded).format('YYYY-MM-DD')}</Description> 
<Description term="Web Site">{retailStoreCountryCenter.webSite}</Description> 
<Description term="Address">{retailStoreCountryCenter.address}</Description> 
<Description term="Operated By">{retailStoreCountryCenter.operatedBy}</Description> 
<Description term="Legal Representative">{retailStoreCountryCenter.legalRepresentative}</Description> 
<Description term="Description">{retailStoreCountryCenter.description}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = retailStoreCountryCenter => {
  const {RetailStoreCountryCenterBase} = GlobalComponents
  return <PermissionSetting targetObject={retailStoreCountryCenter}  targetObjectMeta={RetailStoreCountryCenterBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class RetailStoreCountryCenterPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  retailStoreCountryCenter = this.props.retailStoreCountryCenter;
    const { id,displayName, catalogCount, retailStoreProvinceCenterCount, retailStoreCount, retailStoreMemberCount, goodsSupplierCount, supplyOrderCount, retailStoreOrderCount, warehouseCount, transportFleetCount, accountSetCount, levelOneDepartmentCount, skillTypeCount, responsibilityTypeCount, terminationReasonCount, terminationTypeCount, occupationTypeCount, leaveTypeCount, salaryGradeCount, interviewTypeCount, trainingCourseTypeCount, publicHolidayCount, employeeCount, instructorCount, companyTrainingCount } = retailStoreCountryCenter
    const cardsData = {cardsName:"Retail Store Country Center",cardsFor: "retailStoreCountryCenter",cardsSource: retailStoreCountryCenter,
  		subItems: [
{name: 'skillTypeList', displayName:'Skill Type',type:'skillType',count:skillTypeCount,addFunction: true, role: 'skillType', data: retailStoreCountryCenter.skillTypeList},
{name: 'responsibilityTypeList', displayName:'Responsibility Type',type:'responsibilityType',count:responsibilityTypeCount,addFunction: true, role: 'responsibilityType', data: retailStoreCountryCenter.responsibilityTypeList},
{name: 'terminationReasonList', displayName:'Termination Reason',type:'terminationReason',count:terminationReasonCount,addFunction: true, role: 'terminationReason', data: retailStoreCountryCenter.terminationReasonList},
{name: 'terminationTypeList', displayName:'Termination Type',type:'terminationType',count:terminationTypeCount,addFunction: true, role: 'terminationType', data: retailStoreCountryCenter.terminationTypeList},
{name: 'occupationTypeList', displayName:'Occupation Type',type:'occupationType',count:occupationTypeCount,addFunction: true, role: 'occupationType', data: retailStoreCountryCenter.occupationTypeList},
{name: 'leaveTypeList', displayName:'Leave Type',type:'leaveType',count:leaveTypeCount,addFunction: true, role: 'leaveType', data: retailStoreCountryCenter.leaveTypeList},
{name: 'salaryGradeList', displayName:'Salary Grade',type:'salaryGrade',count:salaryGradeCount,addFunction: true, role: 'salaryGrade', data: retailStoreCountryCenter.salaryGradeList},
{name: 'interviewTypeList', displayName:'Interview Type',type:'interviewType',count:interviewTypeCount,addFunction: true, role: 'interviewType', data: retailStoreCountryCenter.interviewTypeList},
{name: 'trainingCourseTypeList', displayName:'Training Course Type',type:'trainingCourseType',count:trainingCourseTypeCount,addFunction: true, role: 'trainingCourseType', data: retailStoreCountryCenter.trainingCourseTypeList},
{name: 'publicHolidayList', displayName:'Public Holiday',type:'publicHoliday',count:publicHolidayCount,addFunction: true, role: 'publicHoliday', data: retailStoreCountryCenter.publicHolidayList},
    
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
  retailStoreCountryCenter: state._retailStoreCountryCenter,
}))(Form.create()(RetailStoreCountryCenterPermission))


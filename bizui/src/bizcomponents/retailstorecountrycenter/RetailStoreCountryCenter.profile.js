

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import GlobalComponents from '../../custcomponents';
import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './RetailStoreCountryCenter.profile.less'
import DescriptionList from '../../components/DescriptionList';

import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {
  defaultRenderExtraHeader,
  defaultSubListsOf, defaultRenderSettingList,

}= DashboardTool

const { Description } = DescriptionList;

const internalRenderExtraHeader = defaultRenderExtraHeader

const internalSubListsOf = defaultSubListsOf

const internalRenderSettingList = defaultRenderSettingList

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}

const internalSummaryOf = (item, targetComponents)=>{
	
	return GlobalComponents.RetailStoreCountryCenterBase.renderItemOfList(item, targetComponents)

}



class RetailStoreCountryCenterProfile extends Component {

  
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  retailStoreCountryCenter = this.props.retailStoreCountryCenter;
    const { id,displayName, catalogCount, retailStoreProvinceCenterCount, retailStoreCount, retailStoreMemberCount, goodsSupplierCount, supplyOrderCount, retailStoreOrderCount, warehouseCount, transportFleetCount, accountSetCount, levelOneDepartmentCount, skillTypeCount, responsibilityTypeCount, terminationReasonCount, terminationTypeCount, occupationTypeCount, leaveTypeCount, salaryGradeCount, interviewTypeCount, trainingCourseTypeCount, publicHolidayCount, employeeCount, instructorCount, companyTrainingCount } = retailStoreCountryCenter

    const cardsData = {cardsName:"Retail Store Country Center",cardsFor: "retailStoreCountryCenter",cardsSource: retailStoreCountryCenter,
  		subItems: [
{name: 'skillTypeList', displayName:'Skill Type',type:'skillType',count:skillTypeCount,addFunction: true, role: 'skillType',  renderItem: GlobalComponents.SkillTypeBase.renderItemOfList},
{name: 'responsibilityTypeList', displayName:'Responsibility Type',type:'responsibilityType',count:responsibilityTypeCount,addFunction: true, role: 'responsibilityType',  renderItem: GlobalComponents.ResponsibilityTypeBase.renderItemOfList},
{name: 'terminationReasonList', displayName:'Termination Reason',type:'terminationReason',count:terminationReasonCount,addFunction: true, role: 'terminationReason',  renderItem: GlobalComponents.TerminationReasonBase.renderItemOfList},
{name: 'terminationTypeList', displayName:'Termination Type',type:'terminationType',count:terminationTypeCount,addFunction: true, role: 'terminationType',  renderItem: GlobalComponents.TerminationTypeBase.renderItemOfList},
{name: 'occupationTypeList', displayName:'Occupation Type',type:'occupationType',count:occupationTypeCount,addFunction: true, role: 'occupationType',  renderItem: GlobalComponents.OccupationTypeBase.renderItemOfList},
{name: 'leaveTypeList', displayName:'Leave Type',type:'leaveType',count:leaveTypeCount,addFunction: true, role: 'leaveType',  renderItem: GlobalComponents.LeaveTypeBase.renderItemOfList},
{name: 'salaryGradeList', displayName:'Salary Grade',type:'salaryGrade',count:salaryGradeCount,addFunction: true, role: 'salaryGrade',  renderItem: GlobalComponents.SalaryGradeBase.renderItemOfList},
{name: 'interviewTypeList', displayName:'Interview Type',type:'interviewType',count:interviewTypeCount,addFunction: true, role: 'interviewType',  renderItem: GlobalComponents.InterviewTypeBase.renderItemOfList},
{name: 'trainingCourseTypeList', displayName:'Training Course Type',type:'trainingCourseType',count:trainingCourseTypeCount,addFunction: true, role: 'trainingCourseType',  renderItem: GlobalComponents.TrainingCourseTypeBase.renderItemOfList},
{name: 'publicHolidayList', displayName:'Public Holiday',type:'publicHoliday',count:publicHolidayCount,addFunction: true, role: 'publicHoliday',  renderItem: GlobalComponents.PublicHolidayBase.renderItemOfList},
     
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
   
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderSettingList = this.props.renderSettingList || internalRenderSettingList
    
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
       {renderSettingList(cardsData)} 
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  retailStoreCountryCenter: state._retailStoreCountryCenter,
}))(Form.create()(RetailStoreCountryCenterProfile))


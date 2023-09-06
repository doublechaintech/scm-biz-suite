

import React, { Component } from 'react'
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
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
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
    const  returnURL = `/retailStoreCountryCenter/${id}/dashboard`
    const cardsData = {cardsName:"双链小超全国运营中心",cardsFor: "retailStoreCountryCenter",cardsSource: retailStoreCountryCenter,displayName,returnURL,
  		subItems: [
{name: 'skillTypeList', displayName:'技能类型',type:'skillType',count:skillTypeCount,addFunction: true, role: 'skillType',  renderItem: GlobalComponents.SkillTypeBase.renderItemOfList},
{name: 'responsibilityTypeList', displayName:'责任类型',type:'responsibilityType',count:responsibilityTypeCount,addFunction: true, role: 'responsibilityType',  renderItem: GlobalComponents.ResponsibilityTypeBase.renderItemOfList},
{name: 'terminationReasonList', displayName:'雇佣终止的原因',type:'terminationReason',count:terminationReasonCount,addFunction: true, role: 'terminationReason',  renderItem: GlobalComponents.TerminationReasonBase.renderItemOfList},
{name: 'terminationTypeList', displayName:'雇佣终止类型',type:'terminationType',count:terminationTypeCount,addFunction: true, role: 'terminationType',  renderItem: GlobalComponents.TerminationTypeBase.renderItemOfList},
{name: 'occupationTypeList', displayName:'职位类型',type:'occupationType',count:occupationTypeCount,addFunction: true, role: 'occupationType',  renderItem: GlobalComponents.OccupationTypeBase.renderItemOfList},
{name: 'leaveTypeList', displayName:'请假类型',type:'leaveType',count:leaveTypeCount,addFunction: true, role: 'leaveType',  renderItem: GlobalComponents.LeaveTypeBase.renderItemOfList},
{name: 'salaryGradeList', displayName:'工资等级',type:'salaryGrade',count:salaryGradeCount,addFunction: true, role: 'salaryGrade',  renderItem: GlobalComponents.SalaryGradeBase.renderItemOfList},
{name: 'interviewTypeList', displayName:'面试类型',type:'interviewType',count:interviewTypeCount,addFunction: true, role: 'interviewType',  renderItem: GlobalComponents.InterviewTypeBase.renderItemOfList},
{name: 'trainingCourseTypeList', displayName:'培训课程类型',type:'trainingCourseType',count:trainingCourseTypeCount,addFunction: true, role: 'trainingCourseType',  renderItem: GlobalComponents.TrainingCourseTypeBase.renderItemOfList},
{name: 'publicHolidayList', displayName:'公共假日',type:'publicHoliday',count:publicHolidayCount,addFunction: true, role: 'publicHoliday',  renderItem: GlobalComponents.PublicHolidayBase.renderItemOfList},
     
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
   
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderSettingList = this.props.renderSettingList || internalRenderSettingList
    
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData, this)}
        content={summaryOf(cardsData.cardsSource, this)}
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


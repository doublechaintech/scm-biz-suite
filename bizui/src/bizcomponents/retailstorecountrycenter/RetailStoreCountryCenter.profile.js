

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'

import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './RetailStoreCountryCenter.preference.less'
import DescriptionList from '../../components/DescriptionList';

import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {
  defaultRenderExtraHeader,
  defaultSubListsOf,

}= DashboardTool

const { Description } = DescriptionList;

const internalRenderExtraHeader = defaultRenderExtraHeader

const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (retailStoreCountryCenter,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreCountryCenter.id}</Description> 
<Description term="名称">{retailStoreCountryCenter.name}</Description> 
<Description term="服务号码">{retailStoreCountryCenter.serviceNumber}</Description> 
<Description term="成立">{ moment(retailStoreCountryCenter.founded).format('YYYY-MM-DD')}</Description> 
<Description term="网站">{retailStoreCountryCenter.webSite}</Description> 
<Description term="地址">{retailStoreCountryCenter.address}</Description> 
<Description term="由">{retailStoreCountryCenter.operatedBy}</Description> 
<Description term="法定代表人">{retailStoreCountryCenter.legalRepresentative}</Description> 
<Description term="描述">{retailStoreCountryCenter.description}</Description> 
	
      </DescriptionList>
	)
}



class RetailStoreCountryCenterProfile extends Component {

  
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  retailStoreCountryCenter = this.props.retailStoreCountryCenter;
    const { id,displayName, catalogCount, retailStoreProvinceCenterCount, retailStoreCount, retailStoreMemberCount, goodsSupplierCount, supplyOrderCount, retailStoreOrderCount, warehouseCount, transportFleetCount, accountSetCount, levelOneDepartmentCount, skillTypeCount, responsibilityTypeCount, terminationReasonCount, terminationTypeCount, occupationTypeCount, leaveTypeCount, salaryGradeCount, interviewTypeCount, trainingCourseTypeCount, publicHolidayCount, employeeCount, instructorCount, companyTrainingCount } = retailStoreCountryCenter

    const cardsData = {cardsName:"双链小超全国运营中心",cardsFor: "retailStoreCountryCenter",cardsSource: retailStoreCountryCenter,
  		subItems: [
{name: 'skillTypeList', displayName:'技能类型',type:'skillType',count:skillTypeCount,addFunction: true, role: 'skillType', data: retailStoreCountryCenter.skillTypeList},
{name: 'responsibilityTypeList', displayName:'责任类型',type:'responsibilityType',count:responsibilityTypeCount,addFunction: true, role: 'responsibilityType', data: retailStoreCountryCenter.responsibilityTypeList},
{name: 'terminationReasonList', displayName:'雇佣终止的原因',type:'terminationReason',count:terminationReasonCount,addFunction: true, role: 'terminationReason', data: retailStoreCountryCenter.terminationReasonList},
{name: 'terminationTypeList', displayName:'雇佣终止类型',type:'terminationType',count:terminationTypeCount,addFunction: true, role: 'terminationType', data: retailStoreCountryCenter.terminationTypeList},
{name: 'occupationTypeList', displayName:'职位类型',type:'occupationType',count:occupationTypeCount,addFunction: true, role: 'occupationType', data: retailStoreCountryCenter.occupationTypeList},
{name: 'leaveTypeList', displayName:'请假类型',type:'leaveType',count:leaveTypeCount,addFunction: true, role: 'leaveType', data: retailStoreCountryCenter.leaveTypeList},
{name: 'salaryGradeList', displayName:'工资等级',type:'salaryGrade',count:salaryGradeCount,addFunction: true, role: 'salaryGrade', data: retailStoreCountryCenter.salaryGradeList},
{name: 'interviewTypeList', displayName:'面试类型',type:'interviewType',count:interviewTypeCount,addFunction: true, role: 'interviewType', data: retailStoreCountryCenter.interviewTypeList},
{name: 'trainingCourseTypeList', displayName:'培训课程类型',type:'trainingCourseType',count:trainingCourseTypeCount,addFunction: true, role: 'trainingCourseType', data: retailStoreCountryCenter.trainingCourseTypeList},
{name: 'publicHolidayList', displayName:'公共假日',type:'publicHoliday',count:publicHolidayCount,addFunction: true, role: 'publicHoliday', data: retailStoreCountryCenter.publicHolidayList},
    
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
       {subListsOf(cardsData)} 
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  retailStoreCountryCenter: state._retailStoreCountryCenter,
}))(Form.create()(RetailStoreCountryCenterProfile))


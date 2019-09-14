

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import GlobalComponents from '../../custcomponents';
import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './EmployeeQualifier.profile.less'
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
	
	return GlobalComponents.EmployeeQualifierBase.renderItemOfList(item, targetComponents)

}



class EmployeeQualifierProfile extends Component {

  
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  employeeQualifier = this.props.employeeQualifier;
    const { id,displayName,  } = employeeQualifier
    const  returnURL = `/employeeQualifier/${id}/dashboard`
    const cardsData = {cardsName:"员工资质",cardsFor: "employeeQualifier",cardsSource: employeeQualifier,displayName,returnURL,
  		subItems: [
     
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
  employeeQualifier: state._employeeQualifier,
}))(Form.create()(EmployeeQualifierProfile))


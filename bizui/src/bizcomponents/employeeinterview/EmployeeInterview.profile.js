

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'

import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './EmployeeInterview.preference.less'
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


const internalSummaryOf = (employeeInterview,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{employeeInterview.id}</Description> 
<Description term="备注">{employeeInterview.remark}</Description> 
	
      </DescriptionList>
	)
}



class EmployeeInterviewProfile extends Component {

  
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  employeeInterview = this.props.employeeInterview;
    const { id,displayName,  } = employeeInterview

    const cardsData = {cardsName:"员工面试",cardsFor: "employeeInterview",cardsSource: employeeInterview,
  		subItems: [
    
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
  employeeInterview: state._employeeInterview,
}))(Form.create()(EmployeeInterviewProfile))


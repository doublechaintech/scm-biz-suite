

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'

import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Instructor.preference.less'
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


const internalSummaryOf = (instructor,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{instructor.id}</Description> 
<Description term="头衔">{instructor.title}</Description> 
<Description term="姓">{instructor.familyName}</Description> 
<Description term="名">{instructor.givenName}</Description> 
<Description term="手机">{instructor.cellPhone}</Description> 
<Description term="电子邮件">{instructor.email}</Description> 
<Description term="介绍">{instructor.introduction}</Description> 
<Description term="最后更新时间">{ moment(instructor.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}



class InstructorProfile extends Component {

  
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  instructor = this.props.instructor;
    const { id,displayName, companyTrainingCount } = instructor

    const cardsData = {cardsName:"讲师",cardsFor: "instructor",cardsSource: instructor,
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
  instructor: state._instructor,
}))(Form.create()(InstructorProfile))


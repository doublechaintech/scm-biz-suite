

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
import styles from './JobApplication.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (jobApplication,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{jobApplication.id}</Description> 
<Description term="Application Time">{ moment(jobApplication.applicationTime).format('YYYY-MM-DD')}</Description> 
<Description term="Who">{jobApplication.who}</Description> 
<Description term="Comments">{jobApplication.comments}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = jobApplication => {
  const {JobApplicationBase} = GlobalComponents
  return <PermissionSetting targetObject={jobApplication}  targetObjectMeta={JobApplicationBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class JobApplicationPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  jobApplication = this.props.jobApplication;
    const { id,displayName, employeeCount } = jobApplication
    const cardsData = {cardsName:"Job Application",cardsFor: "jobApplication",cardsSource: jobApplication,
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
  jobApplication: state._jobApplication,
}))(Form.create()(JobApplicationPermission))


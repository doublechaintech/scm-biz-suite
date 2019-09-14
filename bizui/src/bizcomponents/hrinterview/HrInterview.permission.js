

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './HrInterview.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (hrInterview,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{hrInterview.id}</Description> 
<Description term="谁">{hrInterview.who}</Description> 
<Description term="面试时间">{ moment(hrInterview.interviewTime).format('YYYY-MM-DD')}</Description> 
<Description term="评论">{hrInterview.comments}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = hrInterview => {
  const {HrInterviewBase} = GlobalComponents
  return <PermissionSetting targetObject={hrInterview}  targetObjectMeta={HrInterviewBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class HrInterviewPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  hrInterview = this.props.hrInterview
    const { id,displayName, employeeCount } = hrInterview
    const  returnURL = `/hrInterview/${id}/dashboard`
    const cardsData = {cardsName:"人力资源部面试",cardsFor: "hrInterview",cardsSource: hrInterview,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
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
  hrInterview: state._hrInterview,
}))(Form.create()(HrInterviewPermission))


import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch,Modal } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './Employee.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import EmployeeBase from './Employee.base'
import SelectObject from '../../components/SelectObject'
<<<<<<< HEAD

=======
import appLocaleName from '../../common/Locale.tool'
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input

const testValues = {};
/*
const testValues = {
  title: '程序员',
  familyName: '张',
  givenName: '文强',
  email: 'share@163.com',
  city: '北京',
  address: '学院路234号',
  cellPhone: '18677778888',
  salaryAccount: '6226 7788 9908 ',
  companyId: 'RSCC000001',
  departmentId: 'LTD000001',
  occupationId: 'OT000001',
  responsibleForId: 'RT000001',
  currentSalaryGradeId: 'SG000001',
}
*/


const imageKeys = [
]


class EmployeeAssociateForm extends Component {
  state = {
    previewVisible: false,
    previewImage: '',
    convertedImagesValues: {},
  }

  componentDidMount() {
 
    
    
    
  }

  handlePreview = (file) => {
    console.log('preview file', file)
    this.setState({
      previewImage: file.url || file.thumbUrl,
      previewVisible: true,
    })
  }

  



  handleChange = (event, source) => {
    console.log('get file list from change in update change:', source)

    const { fileList } = event
    const { convertedImagesValues } = this.state

    convertedImagesValues[source] = fileList
    this.setState({ convertedImagesValues })
    console.log('/get file list from change in update change:', source)
  }
	
  

  render() {
	const { form, dispatch, submitting, role,data,owner,toggleAssociatePaymentVisible,visible,onCancel, onCreate } = this.props
    const { convertedImagesValues } = this.state
    const {EmployeeService} = GlobalComponents
<<<<<<< HEAD
=======
    const userContext = null
    
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
 const {EmployeeCompanyTrainingModalTable} = GlobalComponents;
 const {EmployeeSkillModalTable} = GlobalComponents;
 const {EmployeePerformanceModalTable} = GlobalComponents;
 const {EmployeeWorkExperienceModalTable} = GlobalComponents;
 const {EmployeeLeaveModalTable} = GlobalComponents;
 const {EmployeeInterviewModalTable} = GlobalComponents;
 const {EmployeeAttendanceModalTable} = GlobalComponents;
 const {EmployeeQualifierModalTable} = GlobalComponents;
 const {EmployeeEducationModalTable} = GlobalComponents;
 const {EmployeeAwardModalTable} = GlobalComponents;
 const {EmployeeSalarySheetModalTable} = GlobalComponents;
 const {PayingOffModalTable} = GlobalComponents;


    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const {fieldLabels} = EmployeeBase
    
    const capFirstChar = (value)=>{
    	//const upper = value.replace(/^\w/, c => c.toUpperCase());
  		const upper = value.charAt(0).toUpperCase() + value.substr(1);
  		return upper
  	}
    
    
    

    
    
    const tryinit  = (fieldName, candidates) => {
      
      if(candidates&&candidates.length==1){
          return candidates[0].id
      }
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return null
      }
      return owner.id
    }
    
    const availableForEdit= (fieldName) =>{
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return true
      }
      return false
    
    }
    const formItemLayout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 12 },
    }
    const switchFormItemLayout = {
      labelCol: { span: 14 },
      wrapperCol: { span: 4 },
    }
<<<<<<< HEAD
    
    return (
 <Modal
          title="创建新的支付"
=======
   
    return (
 <Modal
          title={appLocaleName(userContext,"CreateNew")}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
          visible={visible}
          onOk={onCancel}
          onCancel={onCancel}
          width={920}
          style={{ top: 40}}
        >
<<<<<<< HEAD
        <Card title="基础信息"  className={styles.card} style={{ backgroundColor:"#eee" }}>
=======
        <Card title={appLocaleName(userContext,"BasicInfo")}  className={styles.card} style={{ backgroundColor:"#eee" }}>
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
          <Form >
            <Row gutter={16}>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.title} {...formItemLayout}>
                  {getFieldDecorator('title', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入头衔' }],
                  })(
                    <Input placeholder="请输入头衔" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="头衔" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.familyName} {...formItemLayout}>
                  {getFieldDecorator('familyName', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入姓' }],
                  })(
                    <Input placeholder="请输入姓" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="姓" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.givenName} {...formItemLayout}>
                  {getFieldDecorator('givenName', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入名' }],
                  })(
                    <Input placeholder="请输入名" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="名" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.email} {...formItemLayout}>
                  {getFieldDecorator('email', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入电子邮件' }],
                  })(
                    <Input placeholder="请输入电子邮件" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="电子邮件" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.city} {...formItemLayout}>
                  {getFieldDecorator('city', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入城市' }],
                  })(
                    <Input placeholder="请输入城市" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="城市" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.address} {...formItemLayout}>
                  {getFieldDecorator('address', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入地址' }],
                  })(
                    <Input placeholder="请输入地址" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="地址" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.cellPhone} {...formItemLayout}>
                  {getFieldDecorator('cellPhone', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入手机' }],
                  })(
                    <Input placeholder="请输入手机" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="手机" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.salaryAccount} {...formItemLayout}>
                  {getFieldDecorator('salaryAccount', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入工资账户' }],
                  })(
                    <Input placeholder="请输入工资账户" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="工资账户" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

            </Row>


       
        









       
            <Row gutter={16}>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.company} {...formItemLayout}>
                  {getFieldDecorator('companyId', {
                  	initialValue: tryinit('company'),
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入公司' }],
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  })(
                <SelectObject 
                    disabled={!availableForEdit('company')}
                    targetType={"company"} 
                    requestFunction={EmployeeService.requestCandidateCompany}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.department} {...formItemLayout}>
                  {getFieldDecorator('departmentId', {
                  	initialValue: tryinit('department'),
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入部门' }],
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  })(
                <SelectObject 
                    disabled={!availableForEdit('department')}
                    targetType={"department"} 
                    requestFunction={EmployeeService.requestCandidateDepartment}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.occupation} {...formItemLayout}>
                  {getFieldDecorator('occupationId', {
                  	initialValue: tryinit('occupation'),
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入职业' }],
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  })(
                <SelectObject 
                    disabled={!availableForEdit('occupation')}
                    targetType={"occupation"} 
                    requestFunction={EmployeeService.requestCandidateOccupation}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.responsibleFor} {...formItemLayout}>
                  {getFieldDecorator('responsibleForId', {
                  	initialValue: tryinit('responsibleFor'),
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入负责' }],
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  })(
                <SelectObject 
                    disabled={!availableForEdit('responsibleFor')}
                    targetType={"responsibleFor"} 
                    requestFunction={EmployeeService.requestCandidateResponsibleFor}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.currentSalaryGrade} {...formItemLayout}>
                  {getFieldDecorator('currentSalaryGradeId', {
                  	initialValue: tryinit('currentSalaryGrade'),
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入目前工资等级' }],
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  })(
                <SelectObject 
                    disabled={!availableForEdit('currentSalaryGrade')}
                    targetType={"currentSalaryGrade"} 
                    requestFunction={EmployeeService.requestCandidateCurrentSalaryGrade}/>
  
                  )}
                </Form.Item>
              </Col>

            </Row>
         
       

			</Form>
			
			
			
			
        </Card>
        
	<EmployeeCompanyTrainingModalTable data={data.employeeCompanyTrainingList} owner={owner} />
	<EmployeeSkillModalTable data={data.employeeSkillList} owner={owner} />
	<EmployeePerformanceModalTable data={data.employeePerformanceList} owner={owner} />
	<EmployeeWorkExperienceModalTable data={data.employeeWorkExperienceList} owner={owner} />
	<EmployeeLeaveModalTable data={data.employeeLeaveList} owner={owner} />
	<EmployeeInterviewModalTable data={data.employeeInterviewList} owner={owner} />
	<EmployeeAttendanceModalTable data={data.employeeAttendanceList} owner={owner} />
	<EmployeeQualifierModalTable data={data.employeeQualifierList} owner={owner} />
	<EmployeeEducationModalTable data={data.employeeEducationList} owner={owner} />
	<EmployeeAwardModalTable data={data.employeeAwardList} owner={owner} />
	<EmployeeSalarySheetModalTable data={data.employeeSalarySheetList} owner={owner} />
	<PayingOffModalTable data={data.payingOffList} owner={owner} />
        
        
        
      </Modal>)
    
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(EmployeeAssociateForm))





var Todos = Ember.Application.create({
    LOG_TRANSITIONS: true
});

Todos.Router.map(function() {
	this.resource('users', function() {
        this.route('new');
    });

    this.resource('user', {path: '/users/:user_id'}, function() {
        this.resource('todos', function() {
            this.route('new');
        });
        this.route('todo', {path: 'todos/:todo_id'});
    })
});

Todos.UsersRoute = Ember.Route.extend({
	model: function() {
		return this.store.find('user');
	}
});

Todos.UsersIndexRoute=Ember.Route.extend({
    model: function(){
        return this.modelFor('users');
    }
});

Todos.UserIndexRoute = Ember.Route.extend({
    model: function() {
        return this.modelFor('user');
    }
});

// data model
Todos.User = DS.Model.extend({
    name: DS.attr('string'),
    todos: DS.hasMany('todo', {async: true})
});

Todos.Todo = DS.Model.extend({
    description: DS.attr('string'),
    user: DS.belongsTo('user')
});